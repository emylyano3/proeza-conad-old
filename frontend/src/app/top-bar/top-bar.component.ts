import { DOCUMENT } from '@angular/common';
import { Component, OnInit, Inject, Renderer2, ViewChild, ElementRef, AfterViewInit } from '@angular/core';
import { AuthenticationService } from '../auth/_services';
import { Router } from '@angular/router';

@Component({
    selector: 'app-top-bar',
    templateUrl: './top-bar.component.html',
    styleUrls: ['./top-bar.component.scss']
})
export class TopBarComponent implements OnInit, AfterViewInit {
    @ViewChild("filter", { read: ElementRef, static: false }) filter: ElementRef;

    constructor(
        @Inject(DOCUMENT) private document: Document,
        private renderer: Renderer2,
        private authService : AuthenticationService,
        private router: Router
    ) { }

    ngAfterViewInit(): void {
    }

    private showingMenu = true;

    ngOnInit() {
    }

    toggleMenu(): void {
        if (this.showingMenu) {
            this.renderer.addClass(this.document.body, 'hide-sidebar');
        } else {
            this.renderer.removeClass(this.document.body, 'hide-sidebar');
        }
        this.showingMenu = !this.showingMenu;
    }

    doLogout():void {
        this.authService.logout();
        this.router.navigate(['/']);
    }

    hasSearch(): boolean {
        return true;
    }

    erasefilter(): void {
        $(this.filter.nativeElement).val('');
        $(this.filter.nativeElement).trigger('focus');
    }
}
