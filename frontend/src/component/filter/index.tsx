import { useState } from 'react';
import FlatPickr from 'react-flatpickr';
import 'flatpickr/dist/themes/material_green.css';
import flatpickrLib from 'flatpickr';
import { Portuguese } from 'flatpickr/dist/l10n/pt';
import { FilterData, Currancy } from '../../types';
import './styles.css';

flatpickrLib.localize(Portuguese);

type Props = {
  onFilterChange: (filter: FilterData) => void;
};

const Filter = ({ onFilterChange }: Props) => {
  const [dates, setDates] = useState<Date[]>([]);
  const [currancy, setCurrancy] = useState<Currancy>('USD');

  const onChangeDate = (dates: Date[]) => {
    if (dates.length === 2) {
      setDates(dates);
      onFilterChange({ dates, currancy });
    }
  }; 

  const onChangeCurrancy = (event: React.ChangeEvent<HTMLSelectElement>) => {
    const selectedCurrancy = event.target.value as Currancy;
    setCurrancy(selectedCurrancy);
    onFilterChange({ dates, currancy: selectedCurrancy });
  };

  return (

    
    <div className="filter-container base-card">
      <h6 className="filter-title">Filtros para Moeda e Período</h6>
      <FlatPickr
        options={{
          mode: 'range',
          dateFormat: 'd/m/Y',
          showMonths: 2
        }}
        className="filter-input"
        onChange={onChangeDate}
        placeholder="Selecione um período"
      />
      <select className="filter-input" value={currancy} onChange={onChangeCurrancy}>
        <option value="USD">Dólar</option>
        <option value="EUR">Euro</option>
        <option value="BTC">Bitcoin</option>
      </select>
    </div>
 
  );
};

export default Filter;