import { Component, OnInit, Input } from '@angular/core';
import { Dish } from '../week';

@Component({
	selector: 'app-week-detail',
	templateUrl: './week-detail.component.html',
	styleUrls: ['./week-detail.component.css']
})
export class WeekDetailComponent implements OnInit {

	@Input() dish: Dish;

	constructor() { }

	ngOnInit() {
	}

}
