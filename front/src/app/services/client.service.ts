import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ClientModel} from "../model/ClientModel";

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  url = 'http://localhost:52520/api/client';

  user: ClientModel | null = null
  bonusPoints: number = 0

  constructor(private http: HttpClient) {
  }

  register(name: string, password: string) {

    return this.http.post<ClientModel>(this.url + "/registration", {
      name: name,
      password: password
    }, {
      withCredentials: true
    })

  }

  login(name: string, password: string) {

    return this.http.post<ClientModel>(this.url + "/login", {
      name: name,
      password: password
    }, {
      withCredentials: true
    })

  }

  saveFavouriteCoffee(clientId: number, milkId: number, beansId: number, syrupId: number, sizeId: number) {

    return this.http.post(this.url + "/favourite-coffee", {
      client_id: clientId,
      milk_id: milkId,
      beans_id: beansId,
      syrup_id: syrupId,
      size_id: sizeId
    }, {
      withCredentials: true
    })

  }

  getBonusPoints(clientId: number) {
    return this.http.get<number>(this.url + `/bonus-points?id=${clientId}`, {
      withCredentials: true
    })
  }

  spendBonusPoints(clientId: number, bonusPoints: number) {

    return this.http.post(this.url + "/bonus-points", {
      client_id: clientId,
      bonus_points: bonusPoints
    }, {
      withCredentials: true
    })

  }

}
