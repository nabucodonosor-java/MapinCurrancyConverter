import Filter from 'component/filter';
import Header from 'component/header';
import QuoteASKByDateComponent from 'component/quote-ask-by-date';
import QuoteByDateComponent from 'component/quote-bid-by-date';
import { useMemo, useState } from 'react';
import { FilterData } from 'types';
import { buildFiltersParams } from 'utils/request';
import './App.css';

function App() {
  const [filterData, setFilterData] = useState<FilterData>();
  const params = useMemo(() => buildFiltersParams(filterData), [filterData]);

  const onChangeFilterData = (filter: FilterData) => {
    setFilterData(filter);
  };
  
  return (
    <>
      <Header />
      <div className='app-filter-container'>
      <Filter onFilterChange={onChangeFilterData}/>
      </div>
      <div className='app-container'>
      
      <QuoteByDateComponent filterData={filterData} />
      <QuoteASKByDateComponent filterData={filterData} />
      </div>
    </>
  );
}

export default App;
