export class User {
    constructor(
        public userId: number,
        public address: string,
        public username: string,
        public password: string,
        public paymentInfo: string
    ) {

    }
}