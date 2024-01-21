import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ReviewModel} from "../model/ReviewModel";

@Injectable({
  providedIn: 'root'
})
export class ReviewService {
  url = 'http://localhost:52520/api/review';

  constructor(private http: HttpClient) {
  }

  getReviews() {
    return this.http.get<ReviewModel[]>(this.url,{
      withCredentials: true
    })
  }

  createReview(rating: number, text: string, clientId: number) {
    return this.http.post(this.url, {
      rating: rating,
      text: text,
      client_id: clientId
    },{
      withCredentials: true
    })
  }

}
