import {Component, OnInit} from '@angular/core';
import {NgForOf, NgIf} from "@angular/common";
import {ReviewModel} from "../model/ReviewModel";
import {ReviewService} from "../services/review.service";

@Component({
  selector: 'app-reviews',
  standalone: true,
  imports: [
    NgForOf,
    NgIf
  ],
  templateUrl: './reviews.component.html',
  styleUrl: './reviews.component.css'
})
export class ReviewsComponent implements OnInit {

  reviews: ReviewModel[] = []

  constructor(private reviewService: ReviewService) {
  }


  getReviews() {
    this.reviewService.getReviews().subscribe(
      res => this.reviews = res
    )
  }

  ngOnInit(): void {
    this.getReviews()
  }

}
