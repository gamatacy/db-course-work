import {ClientModel} from "./ClientModel";

export class ReviewModel {

  id: number
  rating: number
  text: string
  date: string
  client: ClientModel

  constructor(
    id: number,
    rating: number,
    text: string,
    date: string,
    client: ClientModel
  ) {

    this.id = id
    this.rating = rating
    this.text = text
    this.date = date
    this.client = client

  }

}
