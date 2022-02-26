import { Quote } from "types";
import euro from 'assets/images/euro.jpg';

type Props = {
  quote: Quote; 
}

const EurCard = ({ quote }: Props) => {
  return (
    <div>
      <img src={euro} alt="Sem conexão com a internet!" />
    </div>
  )
}

export default EurCard;