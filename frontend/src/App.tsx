import Filter from 'component/filter';
import Header from 'component/header';
import QuoteASKByDateComponent from 'component/quote-ask-by-date';
import QuoteByDateComponent from 'component/quote-bid-by-date';
import QuoteTable from 'component/quote-table';
import { useMemo, useState } from 'react';
import { FilterData } from 'types';
import { buildFiltersParams } from 'utils/request';
import './assets/styles/custom.scss';
import './App.css';
import EurCard from 'component/current-currancy/eur-card';
import UsdCard from 'component/current-currancy/usd-card';

function App() {
  const [filterData, setFilterData] = useState<FilterData>();
  const params = useMemo(() => buildFiltersParams(filterData), [filterData]);

  const onChangeFilterData = (filter: FilterData) => {
    setFilterData(filter);
  };
  
  return (
    <>
      <Header />
      <div className="app-container">
      <UsdCard />
      <EurCard />
      <Filter onFilterChange={onChangeFilterData}/>      
      <QuoteByDateComponent filterData={filterData} />
      <QuoteASKByDateComponent filterData={filterData} />
      <QuoteTable filterData={filterData} />
      </div>
    </>
  );
}

export default App;
