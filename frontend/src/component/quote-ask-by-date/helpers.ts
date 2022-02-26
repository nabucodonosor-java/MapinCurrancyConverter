import { ApexOptions } from 'apexcharts';
import { QuoteASKByDate, QuoteBIDByDate } from '../../types';

export const chartOptions = {
  legend: {
    show: false
  },
  noData: {
    text: 'Sem resultados',
    align: 'center',
    verticalAlign: 'middle',
    offsetY: -15,
    style: {
      color: '#FFF',
      fontSize: '18px',
      fontFamily: 'Roboto, sans-serif'
    }
  },
  chart: {
    foreColor: '#b4bed2',
    height: 240,
    with: 1000
  },
  plotOptions: {
    bar: {
      horizontal: false,
      columnWidth: '20%',
      endingShape: 'rounded'
    }
  },
  dataLabels: {
    enabled: false
  },
  stroke: {
    show: false
  },
  xaxis: {
    type: 'datetime'
  },
  yaxis: {},
  fill: {
    opacity: 1,
    colors: ['#3e82f7']
  },
  tooltip: {
    theme: 'dark',
    y: {
      formatter: function (val: number) {
        return `R$ ${val}`;
      }
    }
  }
} as ApexOptions;

export const buildChartSeries = (quotesByDate: QuoteBIDByDate[] = []) => {
  /**  sem utilizar o destruction
  return salesByDate.map((sale) => ({
    x: sale.date,
    y: sale.sum
  }));
  */

  /** Utilizando o destruction */
  return quotesByDate.map(({ date, bid }) => ({
    x: date,
    y: bid
  }));
};

export const buildASKChartSeries = (quotesByDate: QuoteASKByDate[] = []) => {
  /**  sem utilizar o destruction
  return salesByDate.map((sale) => ({
    x: sale.date,
    y: sale.sum
  }));
  */

  /** Utilizando o destruction */
  return quotesByDate.map(({ date, ask }) => ({
    x: date,
    y: ask
  }));
};