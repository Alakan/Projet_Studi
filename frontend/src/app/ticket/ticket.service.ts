import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Ticket } from './ticket.model';

@Injectable({
  providedIn: 'root'
})
export class TicketService {
  private apiUrl = 'http://localhost:8080/api/billets';

  constructor(private http: HttpClient) {}

  getTickets(): Observable<Ticket[]> {
    return this.http.get<Ticket[]>(this.apiUrl);
  }

  getTicket(id: number): Observable<Ticket> {
    return this.http.get<Ticket>(`${this.apiUrl}/${id}`);
  }

  createTicket(ticket: Ticket): Observable<Ticket> {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.post<Ticket>(this.apiUrl, ticket, { headers });
  }

  updateTicket(ticket: Ticket): Observable<Ticket> {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.put<Ticket>(`${this.apiUrl}/${ticket.id}`, ticket, { headers });
  }

  deleteTicket(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
