import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule ,MatNativeDateModule } from '@angular/material';
import {MatDialogModule} from '@angular/material/dialog';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';

import {MatSelectModule} from '@angular/material/select';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatDatepickerModule } from '@angular/material/datepicker';

import {MatRadioModule} from '@angular/material/radio';
import { PageService } from './page.service';
import { Page1Component } from './page1/page1.component';
import { Page2Component } from './page2/page2.component';
import { Page3Component } from './page3/page3.component';


const appRoutes: Routes = [
  {
    path: '',
    redirectTo: 'page1',
    pathMatch: 'full'
    },
    {
      path: 'page1',
      component: Page1Component
    },
    {
      path: 'page2',
      component: Page2Component
    },
    {
      path: 'page3/:id',
      component: Page3Component
    }
];
@NgModule({
  declarations: [
    AppComponent,
    Page1Component,
    Page2Component,
    Page3Component,

  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatListModule,
    MatToolbarModule,
    FormsModule,
    MatDatepickerModule,
    MatFormFieldModule,
    MatSelectModule,
    MatRadioModule,
    MatNativeDateModule,
    MatDialogModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [PageService],
  bootstrap: [AppComponent]
})
export class AppModule { }
