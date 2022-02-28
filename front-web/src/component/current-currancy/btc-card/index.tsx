import { Quote } from "types";
import bitcoinLogo from 'images/bitcoin.png';
import { useEffect, useState } from "react";
import { makeRequest } from "utils/request";
import { formatDate, formatPriceBitcoin, formatPrice } from "utils/formatters";

const BtcCard = () => {
  const [bitcoin, setBitcoin] = useState<Quote>();
  const [convert, setConvert] = useState(0);
  const [isLoading, setIsLoading] = useState(false);

  useEffect(() => {
    setIsLoading(true);
    makeRequest
      .get<Quote>('/quotes/current-btc')
      .then((response) => {
        setBitcoin(response.data);
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
        <img src={bitcoinLogo} alt="Sem conexão com a internet" width="10%" />
        <h6>Cotação do Bitcoin</h6>
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
            <td>{bitcoin?.date && (
                formatDate(bitcoin?.date))}</td><td>{bitcoin?.code}</td><td>{bitcoin?.bid && (
                  formatPrice(bitcoin?.bid)
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
              <th>Valor em Bitcoin</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td><input type="number" id="name" name="name" step="any"
                onChange={(e) => {
                  let selectedValue = e.target.value;
                  setConvert(parseFloat(selectedValue));
                }} /></td>
              <td>{bitcoin?.bid && (
                <h4 className="formatPriceBitcoin">{formatPriceBitcoin(convert / bitcoin?.bid)}</h4>
              )}</td>

            </tr>
          </tbody>
        </table>
      </div>
    </div>
  )
}

export default BtcCard;