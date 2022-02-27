import { Currancy } from '../types';

export const formatPrice = (price: number) => {
  return new Intl.NumberFormat('pt-BR', {
    minimumFractionDigits: 2,
    style: 'currency',
    currency: 'BRL'
  }).format(price);
};

export const formatPriceEuro = (price: number) => {
  return new Intl.NumberFormat('pt-BR', {
    minimumFractionDigits: 2,
    style: 'currency',
    currency: 'EUR'
  }).format(price);
};

export const formatPriceDollar = (price: number) => {
  return new Intl.NumberFormat('pt-BR', {
    minimumFractionDigits: 2,
    style: 'currency',
    currency: 'USD'
  }).format(price);
};

export const formatPriceBitcoin = (price: number) => {
  return new Intl.NumberFormat('pt-BR', {
    minimumFractionDigits: 2,
    style: 'currency',
    currency: 'BTC'
  }).format(price);
};


export const formatDate = (date: Date | string) => {
  let correctDate = new Date(date);
  correctDate.setDate(correctDate.getDate() + 1);
  return correctDate.toLocaleDateString();;
};

export const formatDateToServer = (date?: Date) => {
  if (date) {
    return date?.toISOString().substring(0, 10);
  }
};

export const formatCurrancy = (currancy: Currancy) => {
  const textByCurrancy = {
    USD: 'dolar',
    EUR: 'euro',
    BTC: 'bitcoin'
  };

  return textByCurrancy[currancy];
};