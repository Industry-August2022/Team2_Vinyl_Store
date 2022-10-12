import { Vinyl } from "./vinyl";

export class Category {
    constructor(
        public categoryId: number,
        public name: string,
        public vinyl: Vinyl[]
    ) {

    }
}