export interface Ticket {
  id: number;
  sport: string;
  price: number;
  date: string;
  utilisateur: {
    id: number;
    nom: string;
    prenom: string;
    email: string;
  };
  commande: {
    id: number;
    dateCommande: string;
    statut: string;
  };
  cleBillet: string;
  qrcode: string;
}
