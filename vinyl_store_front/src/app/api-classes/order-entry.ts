export class OrderEntry {
    constructor(
        public orderEntryId: number,
        public cartId: number,
        public vinylId: number,
        public quantity: number
    ) {

    }
}