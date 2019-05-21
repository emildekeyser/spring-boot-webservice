import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { Hero } from './hero';
// import { HEROES } from './mock-heroes';

@Injectable({
	providedIn: 'root'
})

export class HeroService {

	private heroesUrl = 'http://localhost:8080/heroes';

	constructor(private http: HttpClient) {}

	getHeroes(): Observable<Hero[]> {
		// return of(HEROES);
		return this.http.get<Hero[]>(this.heroesUrl);
	}
}
