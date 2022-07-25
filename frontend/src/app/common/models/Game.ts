import { DomSanitizer, SafeUrl } from "@angular/platform-browser";
import { Cover } from "./Cover";

export class Game {
    title: string = "";
    description: string = "";
    price: number = 0;
    releaseDate: string = "";
    cover: Cover = new Cover();
    coverImgUrl: SafeUrl = "";

    constructor(private sanitizer : DomSanitizer) {
        this.coverImgUrl = this.getCoverImageUrl();
    }

    public getCoverImageUrl() {
        return this.sanitizer.bypassSecurityTrustUrl(URL.createObjectURL(this.cover.blob));
    }

}
