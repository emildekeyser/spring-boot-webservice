import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { Week } from './week';
import { DayMenu } from './week';
import { Dish } from './week';

@Injectable({
	providedIn: 'root'
})

export class WeekService {

	private weeksUrl = 'http://localhost:8080/weekmenu';

	constructor(private http: HttpClient) {}

	getWeeks(): Observable<Week[]> {
		return this.http.get<Week[]>(this.weeksUrl);
	}
}
