import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {AllergenModel} from "../model/AllergenModel";

@Injectable({
  providedIn: 'root'
})
export class AllergenService {

  url = 'http://localhost:52520/api/allergen';

  constructor(private http: HttpClient) {
  }

  getSyrupAllergens(syrupId: number) {
    return this.http.get<AllergenModel[]>(this.url + `/syrup?syrup_id=${syrupId}`,{
      withCredentials: true
    })
  }

  getMilkAllergens(milkId: number) {
    return this.http.get<AllergenModel[]>(this.url + `/milk?milk_id=${milkId}`,{
      withCredentials: true
    })
  }

  getFillingAllergens(fillingId: number) {
    return this.http.get<AllergenModel[]>(this.url + `/filling?filling_id=${fillingId}`,{
      withCredentials: true
    })
  }

}
