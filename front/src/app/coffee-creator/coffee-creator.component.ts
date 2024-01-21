import {Component, OnInit} from '@angular/core';
import {CoffeeService} from "../services/coffee.service";
import {AdditiveModel} from "../model/AdditiveModel";
import {HttpClientModule} from "@angular/common/http";
import {NgForOf, NgIf} from "@angular/common";
import {MatChip, MatChipListbox, MatChipOption} from "@angular/material/chips";
import {OrderService} from "../services/order.service";
import {CoffeeModel} from "../model/CoffeeModel";
import {log} from "@angular-devkit/build-angular/src/builders/ssr-dev-server";
import {AllergenModel} from "../model/AllergenModel";
import {AllergenService} from "../services/allergen.service";

@Component({
  selector: 'app-coffee-creator',
  standalone: true,
  imports: [HttpClientModule, NgForOf, MatChip, MatChipListbox, MatChipOption, NgIf],
  templateUrl: './coffee-creator.component.html',
  styleUrl: './coffee-creator.component.css'
})
export class CoffeeCreatorComponent implements OnInit {

  constructor(private coffeeService: CoffeeService, private orderService: OrderService, private allergenService: AllergenService) {
  }


  sizes: AdditiveModel[] = []
  currentSize: AdditiveModel | null = null

  beans: AdditiveModel[] = []
  currentBeans: AdditiveModel | null = null

  milk: AdditiveModel[] = []
  currentMilk: AdditiveModel | null = null

  syrup: AdditiveModel[] = []
  currentSyrup: AdditiveModel | null = null

  allergens: AllergenModel[] = []

  getSizes() {
    this.coffeeService.getSize().subscribe(
      res => {
        this.sizes = res
        this.currentSize = this.sizes[0]
      }
    )
  }

  selectSize(size: AdditiveModel) {
    this.currentSize = size
  }

  getBeans() {
    this.coffeeService.getBeans().subscribe(
      res => {
        this.beans = res
        this.currentBeans = this.beans[0]
      }
    )
  }

  selectBeans(beans: AdditiveModel) {
    this.currentBeans = beans
  }

  getMilk() {
    this.coffeeService.getMilk().subscribe(
      res => this.milk = res
    )
  }

  selectMilk(milk: AdditiveModel) {
    this.currentMilk = milk
    this.allergens = []
    this.allergenService.getMilkAllergens(milk.id).subscribe(
      res => res.forEach(
        r => this.allergens.push(r)
      )
    )
  }

  getSyrup() {
    this.coffeeService.getSyrups().subscribe(
      res => this.syrup = res
    )
  }

  selectSyrup(syrup: AdditiveModel) {
    this.currentSyrup = syrup
    this.allergens = []
    this.allergenService.getSyrupAllergens(syrup.id).subscribe(
      res => res.forEach(
        r => this.allergens.push(r)
      )
    )
  }

  addToCart() {
    this.orderService.coffeeCart.push(
      new CoffeeModel(0, this.currentMilk, this.currentBeans, this.currentSyrup, this.currentSize)
    )
    console.log(this.orderService.coffeeCart)
  }

  ngOnInit(): void {
    this.getSizes()
    this.getBeans()
    this.getMilk()
    this.getSyrup()
  }

}
