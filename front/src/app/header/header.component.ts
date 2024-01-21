import {Component, Input, Output} from '@angular/core';
import {CartComponent} from "./cart/cart.component";
import {NgIf} from "@angular/common";
import {ClientModel} from "../model/ClientModel";
import {ClientService} from "../services/client.service";
import {FormsModule} from "@angular/forms";

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [
    CartComponent,
    NgIf,
    FormsModule
  ],
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent {

  cartVisible: boolean = false
  username: string = ''
  password: string = ''

  constructor(protected clientService: ClientService) {
  }

  setCartVisible() {
    this.cartVisible = !this.cartVisible
  }

  register() {
    this.clientService.register(this.username, this.password).subscribe(
      res => {
        this.clientService.user = res
        this.clientService.getBonusPoints(res.id).subscribe(
          res => this.clientService.bonusPoints = res
        )
      }
    )
  }

  login() {
    this.clientService.login(this.username, this.password).subscribe(
      res => {
        this.clientService.user = res
        this.clientService.getBonusPoints(res.id).subscribe(
          res => this.clientService.bonusPoints = res
        )
      }
    )
  }

}
