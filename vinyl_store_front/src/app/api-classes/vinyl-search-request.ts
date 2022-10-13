export class VinylSearchRequest {
    constructor( 
        public query:string | null,
        public artistId:number,
        public genreId:number,
        public studioId:number,
        public orderBy:string | null
        ){}
   
}