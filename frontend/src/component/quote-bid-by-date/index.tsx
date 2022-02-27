import { useEffect, useMemo, useState } from 'react';
import ReactApexChart from 'react-apexcharts';
import { ChartSeriesData, FilterData, QuoteBIDByDate } from '../../types';
import { formatDate } from '../../utils/formatters';
import { buildFiltersParams, makeRequest } from '../../utils/request';
import { buildChartSeries, chartOptions } from './helpers';
import './styles.css';

type Props = {
  filterData?: FilterData;
};

const QuoteBIDByDateComponent = ({ filterData }: Props) => {
  const [chartSeries, setChartSeries] = useState<ChartSeriesData[]>([]);
  const params = useMemo(() => buildFiltersParams(filterData), [filterData]);

  useEffect(() => {
    makeRequest
      .get<QuoteBIDByDate[]>('/quotes/by-date', { params })
      .then((response) => {
        const newChartSeries = buildChartSeries(response.data);
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
        <h4 className="quotes-by-date-title">Cotação para VENDA - {params.currancy}</h4>
        {filterData?.dates && (
          <span className="quotes-by-date-period">
            {filterData?.dates.length === 0 ? '' : formatDate(filterData?.dates?.[0])} {filterData?.dates.length === 0 ? '' : '-'} {filterData?.dates.length === 0 ? '' : formatDate(filterData?.dates?.[1])}
          </span>
        )}
      </div>        
        <div>
          <ReactApexChart
            type="bar"
            options={chartOptions}
            series={[{ name: 'bid', data: chartSeries }]}
            height={200}
            width="100%"
          />
        </div>
     
    </div>
  );
};

export default QuoteBIDByDateComponent;