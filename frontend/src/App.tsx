import Filter from 'component/filter';
import Header from 'component/header';
import QuoteByDateComponent from 'component/quote-by-date';
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
      <div className='app-container'>
      <Filter onFilterChange={onChangeFilterData} />
      <QuoteByDateComponent filterData={filterData} />
      </div>
    </>
  );
}

export default App;
