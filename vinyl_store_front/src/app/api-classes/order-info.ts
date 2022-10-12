import { OrderEntry } from "./order-entry";

export class OrderInfo {
    constructor(
        public cartId: number,
        public customerId: number,
        public datePlaced: string,
        public cartContents: OrderEntry[]
    ) {

    }
}