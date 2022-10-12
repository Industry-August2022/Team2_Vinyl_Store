import { CartContent } from "./cart-content";

export class Cart {
    constructor(
        public cartId: number,
        public customerId: number,
        public cartContents: CartContent[]
    ) {

    }
}