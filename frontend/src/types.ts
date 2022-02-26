export type QuoteBIDByDate = {
  date: string;
  bid: number;
};

export type QuoteASKByDate = {
  date: string;
  ask: number;
};

export type ChartSeriesData = {
  x: string;
  y: number;
};

export type Currancy = 'USD' | 'EUR';

export type FilterData = {
  dates?: Date[];
  currancy?: Currancy;
};

export type Quote = {
  id: number;
  date: string;
  code: string;
  name: string;
  bid: number;
  ask: number;
  high: number;
  low: number;
};

export type QuoteResponse = {
  content: Quote[];
};