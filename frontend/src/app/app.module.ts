import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { ProfilComponent } from './profil/profil.component';
import { RechercheComponent } from './recherche/recherche.component';
import { CommandesComponent } from './commandes/commandes.component';

const routes: Routes = [
  { path: '', redirectTo: '/accueil', pathMatch: 'full' },
  { path: 'accueil', component: AppComponent },
  { path: 'profil', component: ProfilComponent },
  { path: 'recherche', component: RechercheComponent },
  { path: 'commandes', component: CommandesComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    ProfilComponent,
    RechercheComponent,
    CommandesComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
