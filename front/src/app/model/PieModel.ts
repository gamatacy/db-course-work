import {AdditiveModel} from "./AdditiveModel";

export class PieModel {

  id: number
  filling: AdditiveModel | null
  size: AdditiveModel | null

    constructor(id: number, filling: AdditiveModel | null, size: AdditiveModel | null) {
    this.id = id;
    this.filling = filling;
    this.size = size;
  }

}
