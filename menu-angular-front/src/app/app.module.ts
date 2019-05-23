import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { WeeksComponent } from './weeks/weeks.component';
import { WeekDetailComponent } from './week-detail/week-detail.component';

@NgModule({
  declarations: [
    AppComponent,
    WeeksComponent,
    WeekDetailComponent
  ],
  imports: [
	  BrowserModule,
	  FormsModule,
	  HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
