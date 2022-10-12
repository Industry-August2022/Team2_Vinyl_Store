export class Vinyl {
    constructor(
        public vinylId: number,
        public genreId: number,
        public studioId: number,
        public artistId: number,
        public title: string,
        public description: string,
        public releaseDate: string,
        public priceCents: number,
        public coverArtUrl: string,
        public runtime: number,
        public stockQuantity: number,
        public timesOrdered: number,
        public isExplicit: boolean,
        public isArchived: boolean
    ) {

    }
}