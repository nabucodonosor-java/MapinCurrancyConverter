import axios from 'axios';
import { FilterData } from '../types';
import { formatDateToServer } from './formatters';

if (process.env.REACT_APP_BACKEND_URL) {
  axios.defaults.baseURL = process.env.REACT_APP_BACKEND_URL;
}

const BASE_URL = process.env.REACT_APP_BACKEND_URL ?? 'http://localhost:8081';

const baseURL = BASE_URL;

export const makeRequest = axios.create({
  baseURL
});

export const buildFiltersParams = (
  filterData?: FilterData,
  extraParams?: Record<string, unknown>
) => {
  return {
    minDate: formatDateToServer(filterData?.dates?.[0]),
    maxDate: formatDateToServer(filterData?.dates?.[1]),
    currancy: filterData?.currancy,
    ...extraParams
  };
};