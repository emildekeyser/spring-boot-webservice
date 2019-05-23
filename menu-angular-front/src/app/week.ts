export class Week {
	id: number;
	week: Map<number, DayMenu>;
}

export class DayMenu {
	date: string;
	soep: Dish;
	dagschotel: Dish;
	veggie: Dish;
}

export class Dish {
	name: string;
	description: string;
	price: number;
	type: string
	dayName: string;
}
