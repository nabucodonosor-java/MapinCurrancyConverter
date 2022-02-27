import axios from 'axios';
import { FilterData } from '../types';
import { formatDateToServer } from './formatters';

const baseURL = 'https://mapin-convert.herokuapp.com' ?? process.env.REACT_APP_BACKEND_URL;

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