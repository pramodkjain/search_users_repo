import {RepositoryOwner} from './repository.owner';

export class Repository {
  constructor(public id: string,
              public name: string,
              public description:String,
              public fork: boolean,
              public forksCount: number,
              public owner:RepositoryOwner,
              public starGazersCount:number) {
  }
}
