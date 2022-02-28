import { Quote } from "types";
import dolarLogo from 'images/dolar.jpg';
import { useEffect, useState } from "react";
import { makeRequest } from "utils/request";
import { formatDate, formatPrice, formatPriceDollar } from "utils/formatters";

const UsdCard = () => {
  const [dolar, setDolar] = useState<Quote>();
  const [convert, setConvert] = useState(0);
  const [isLoading, setIsLoading] = useState(false);

  useEffect(() => {
    makeRequest
      .get<Quote>('/quotes/current-usd')
      .then((response) => {
        setDolar(response.data);
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
        <img src={dolarLogo} alt="Sem conexão com a internet" width="10%" />
        <h6>Cotação do Dólar</h6>
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
            <td>{dolar?.date && (
                formatDate(dolar?.date))}</td><td>{dolar?.code}</td><td>{dolar?.bid && (
                  formatPrice(dolar?.bid)
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
              <th>Valor em Dólar US$</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td><input type="number" id="name" name="name" step="any"
                onChange={(e) => {
                  let selectedValue = e.target.value;
                  setConvert(parseFloat(selectedValue));
                }} /></td>
              <td>{dolar?.bid && (
                <h4 className="formatPriceDollar">{formatPriceDollar(convert / dolar?.bid)}</h4>
              )}</td>

            </tr>
          </tbody>
        </table>
      </div>
    </div>
  )
}

export default UsdCard;