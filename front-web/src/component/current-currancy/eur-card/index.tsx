import { Quote } from "types";
import euroLogo from 'images/euro.jpg';
import { useEffect, useState } from "react";
import { makeRequest } from "utils/request";
import { formatDate, formatPrice, formatPriceEuro } from "utils/formatters";
import './styles.css';

const EurCard = () => {
  const [euro, setEuro] = useState<Quote>();
  const [convert, setConvert] = useState(0);
  const [isLoading, setIsLoading] = useState(false);

  useEffect(() => {
    setIsLoading(true);
    makeRequest
      .get<Quote>('/quotes/current-eur')
      .then((response) => {
        setEuro(response.data);
      })
      .catch(() => {
        console.error('Erro de integração coma API');
      })
      .finally(() => {
        setIsLoading(false);
      });
  }, []);

  return (
    <div className="card-currancy-container base-card">   
      <div className="card-title">
        <img src={euroLogo} alt="Sem conexão com a internet" width="10%" />
        <h6>Cotação do Euro</h6>
      </div>
      <table className="card-table">
        <thead>
          <tr>
            <th>Data</th>
            <th>Moeda</th>
            <th>VALOR</th>
          </tr>
        </thead>
        <tbody>
          <tr>
          {isLoading ? <h6>CARREGANDO INFORMAÇÕES ..</h6> : (
            <>
            <td>{euro?.date && (
                formatDate(euro?.date))}</td><td>{euro?.code}</td><td>{euro?.bid && (
                  formatPrice(euro?.bid)
              )}
            </td>
            </>
          )}
          </tr>


        </tbody>
      </table>
      <div className="convert-container">
      <h5 className="mb-3 mt-1"><u>CONVERSOR</u></h5>
        <table className="convert-table">
          <thead>
            <tr>
              <th>Valor em Reais R$</th>
              <th>Valor em Euro</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td><input type="number" id="name" name="name" step="any"
                onChange={(e) => {
                  let selectedDay = e.target.value;
                  setConvert(parseFloat(selectedDay));
                }} /></td>
              <td>{euro?.bid && (
                <h4 className="formatPriceEuro">{formatPriceEuro(convert / euro?.bid)}</h4>
              )}</td>

            </tr>


          </tbody>
        </table>

      </div>
    </div>
  )
}

export default EurCard;