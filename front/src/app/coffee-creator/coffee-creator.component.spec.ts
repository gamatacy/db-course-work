import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CoffeeCreatorComponent } from './coffee-creator.component';

describe('CoffeeCreatorComponent', () => {
  let component: CoffeeCreatorComponent;
  let fixture: ComponentFixture<CoffeeCreatorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CoffeeCreatorComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CoffeeCreatorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
