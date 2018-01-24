import {Repository} from "../common/model/repository";

export class SearchResultInput {
  constructor(public repositoryArray: Repository[]) {
  }
}
