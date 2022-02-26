import { useEffect, useMemo, useState } from 'react';
import ReactApexChart from 'react-apexcharts';
import { ChartSeriesData, FilterData, QuoteASKByDate } from '../../types';
import { formatDate } from '../../utils/formatters';
import { buildFiltersParams, makeRequest } from '../../utils/request';
import { buildASKChartSeries, chartOptions } from './helpers';
import './styles.css';

type Props = {
  filterData?: FilterData;
};

const QuoteASKByDateComponent = ({ filterData }: Props) => {
  const [chartSeries, setChartSeries] = useState<ChartSeriesData[]>([]);
  const params = useMemo(() => buildFiltersParams(filterData), [filterData]);

  useEffect(() => {
    makeRequest
      .get<QuoteASKByDate[]>('/quotes/ask/by-date', { params })
      .then((response) => {
        const newChartSeries = buildASKChartSeries(response.data);
        console.log(newChartSeries);
        setChartSeries(newChartSeries);
      })
      .catch(() => {
        console.error('Erro de integração coma API');
      });
  }, [params]);

  return (
    <div className="quotes-by-date-container base-card">
      <div>
        <h4 className="quotes-by-date-title">Cotação para COMPRA - {params.currancy === 'USD' ? 'Dólar' : 'Euro'}</h4>
        {filterData?.dates && (
          <span className="sales-by-date-period">
            {filterData?.dates.length === 0 ? '' : formatDate(filterData?.dates?.[0])} {filterData?.dates.length === 0 ? '' : '-'} {filterData?.dates.length === 0 ? '' : formatDate(filterData?.dates?.[1])}
          </span>
        )}
      </div>        
        <div>
          <ReactApexChart
            type="bar"
            options={chartOptions}
            series={[{ name: 'ask', data: chartSeries }]}
            height={200}
            width={600}
          />
        </div>
     
    </div>
  );
};

export default QuoteASKByDateComponent;