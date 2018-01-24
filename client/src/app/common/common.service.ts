import {Injectable} from "@angular/core";

@Injectable()
export class CommonService {
  public error: string = '';
  public message: string = '';

  public clearErrMsg() {
    this.error = '';
    this.message = '';
  }

  public setError(errMsg: string) {
    this.error = errMsg;
  }

  public setMessage(message: string) {
    this.message = message;
  }

  public handleSuccess(response, msg: string) {
    console.log(JSON.stringify(response));
    this.clearErrMsg();
    this.setMessage(msg);
  }

  public handleError(error: any) {
    console.log(JSON.stringify(error));
    this.clearErrMsg();
    if (error && error._body) {
      this.setError(error._body);
    } else {
      this.setError("Fatal Error!");
    }
  }


}
