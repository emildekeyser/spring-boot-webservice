import { Component, OnInit } from '@angular/core';
import { Week } from '../week';
import { Dish } from '../week';
import { WeekService } from '../week.service';

@Component({
	selector: 'app-weeks',
	templateUrl: './weeks.component.html',
	styleUrls: ['./weeks.component.css']
})

export class WeeksComponent implements OnInit {

	weeks: Week[];

	selectedDish: Dish;
	onSelect(dish: Dish): void {
		this.selectedDish = dish;
	}

	constructor(private weekService: WeekService) { }

	ngOnInit() {
		this.weekService.getWeeks()
			.subscribe(weeks => this.weeks = weeks);
	}
}
