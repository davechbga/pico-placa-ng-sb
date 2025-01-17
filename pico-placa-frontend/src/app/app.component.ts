import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import {
  FormBuilder,
  FormGroup,
  FormsModule,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { ResultModalComponent } from './components/result-modal/result-modal.component';
import { ValidationResponse } from './models/validation-response.model';
import { ValidationService } from './services/validation.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    ResultModalComponent,
  ],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'pico-placa-frontend';
  form: FormGroup;
  isLoading = false;
  formSubmitted = false;
  result: string = '';
  errorMessage: string = '';
  showModal = false;

  // Inyectar el servicio de validación
  constructor(
    private validationService: ValidationService,
    // Inyectar el constructor de formularios
    private fb: FormBuilder
  ) {
    this.form = this.fb.group({
      plate: [
        '',
        [Validators.required, Validators.pattern('^[A-Z]{3}-\\d{4}$')],
      ],
      date: [
        '',
        [Validators.required, Validators.pattern('^\\d{4}-\\d{2}-\\d{2}$')],
      ],
      hour: ['', [Validators.required, Validators.pattern('^\\d{2}:\\d{2}$')]],
    });
  }

  // Método para validar la placa
  validate(): void {
    this.formSubmitted = true;
    if (this.form.invalid) {
      this.errorMessage = 'Por favor, corrija los errores en el formulario.';
      return;
    }

    this.isLoading = true;
    this.validationService.validatePlate(this.form.value).subscribe({
      next: (response: ValidationResponse) => this.handleSuccess(response),
      error: () => this.handleError(),
    });
  }

  // Método para manejar la respuesta exitosa
  private handleSuccess(response: ValidationResponse): void {
    if (
      response.response ===
      'La fecha y hora ingresada no puede ser anterior a la actual.'
    ) {
      this.errorMessage = response.response;
      this.showModal = false;
    } else {
      this.result = response.response;
      this.showModal = true;
      this.errorMessage = '';
    }
    this.isLoading = false;
  }

  // Método para manejar errores
  private handleError(): void {
    this.errorMessage =
      'Error en el servidor. Por favor, inténtelo de nuevo más tarde.';
    this.showModal = false;
    this.isLoading = false;
  }
  
  // Método para cerrar el modal
  closeModal() {
    this.showModal = false;
  }
}
