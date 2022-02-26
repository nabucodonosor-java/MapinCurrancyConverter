import Pagination from 'component/pagination';
import { useCallback, useEffect, useMemo, useState } from 'react';
import { FilterData, QuoteResponsePage } from '../../types';
import { formatDate, formatPrice } from '../../utils/formatters';
import { buildFiltersParams, makeRequest } from '../../utils/request';
import './styles.css';

type Props = {
  filterData?: FilterData;
};

const extraParams = {
  page: 0,
  size: 12,
  sort: 'date,desc'
};



const QuoteTable = ({ filterData }: Props) => {
  const params = useMemo(() => buildFiltersParams(filterData, extraParams), [filterData]);
  const [activePage, setActivePage] = useState(0);
  const [isLoading, setIsLoading] = useState(false);
  const [quoteResponse, setQuoteResponse] = useState<QuoteResponsePage>();


  const getQuotes = useCallback(() => {

    setIsLoading(true);
    makeRequest({ url: `/quotes?page=${activePage}`, params })
      .then(response => setQuoteResponse(response.data))
      .finally(() => {
        setIsLoading(false);
      })
  }, [activePage, params]);

  useEffect(() => {
    getQuotes();
  }, [getQuotes]);

  return (
    <>
      <div className="table-responsive base-card">
        <h4 className="text-center mt-1">Histórico de cotações</h4>
        {isLoading ? <h1>Carregando ...</h1> : (
          <table className="sales-table">
            <thead>
              <tr className="text-center">
                <th>Data</th>
                <th>Moeda</th>
                <th>VALOR</th>
              </tr>
            </thead>
            <tbody>
              {quoteResponse?.content.map(item => (
                <tr key={item.id}>
                  <td>{formatDate(item.date)}</td>
                  <td>{item.code}</td>
                  <td>{formatPrice(item.bid)}</td>
                </tr>
              ))}

            </tbody>
          </table>
        )}
      </div>
      <div>
        {quoteResponse && (
          <Pagination
            totalPages={quoteResponse.totalPages}
            onChange={page => setActivePage(page)}
          />
        )}
      </div>
    </>
  );
};

export default QuoteTable;