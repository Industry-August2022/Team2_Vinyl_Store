export class LoginResponse {
    constructor(
        public message: string,
        public success: boolean,
        public userId: number
    ) {

    }
}