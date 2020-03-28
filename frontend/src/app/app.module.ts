import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AgGridModule } from 'ag-grid-angular';
import { AuthenticationModule } from './auth/authentication.module';

import { AppComponent } from './app.component';
import { TopBarComponent } from './top-bar/top-bar.component';
import { MainMenuComponent } from './main-menu/main-menu.component';
import { FooterComponent } from './footer/footer.component';
import { UserListComponent } from './user/user-list/user-list.component';
import { ArticuloListComponent } from './articulo/articulo-list/articulo-list.component';
import { HomeComponent } from './home/home/home.component';

import { MenuEntryDirective } from './main-menu/menu-entry.directive';

import { MenuDataProviderService } from './main-menu/menu-data-provider.service';
import { AuthenticationService } from './auth/_services/authentication.service';

// AGregado para tener la funcionalidad de menu contextual. 
// Se puede reemplazar esa funcionalidad con una columna de Acciones en la grilla
import 'ag-grid-enterprise';
import * as $ from "jquery";

@NgModule({
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    AuthenticationModule,
    AgGridModule.withComponents([]),
    AppRoutingModule
  ],
  declarations: [
    AppComponent,
    TopBarComponent,
    MainMenuComponent,
    FooterComponent,
    UserListComponent,
    MenuEntryDirective,
    ArticuloListComponent,
    HomeComponent
  ],
  providers: [MenuDataProviderService, AuthenticationService],
  bootstrap: [AppComponent]
})
export class AppModule { }
