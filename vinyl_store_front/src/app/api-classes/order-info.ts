import { OrderEntry } from "./order-entry";

export class OrderInfo {
    constructor(
        public orderInfoId: number,
        public customerId: number,
        public datePlaced: string,
        public orderEntries: OrderEntry[]
    ) {

    }
}