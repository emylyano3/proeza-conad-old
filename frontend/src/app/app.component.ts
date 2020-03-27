import { Component } from '@angular/core';
import { AuthenticationService } from './auth/_services/authentication.service';

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.scss']
})
export class AppComponent {

    constructor(
        private authService: AuthenticationService
    ) {
    }
    title = 'Proeza Conad';

    isLoggedIn(): boolean {
        return this.authService.currentUserValue != null;
    }
}
