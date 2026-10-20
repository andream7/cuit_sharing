// src/services/TransactionService.js
import axios from 'axios';

const API_URL = 'http://localhost:8080/api/transactions';

class TransactionService {
    getAllTransactions() {
        return axios.get(API_URL);
    }

    getTransaction(id) {
        return axios.get(`${API_URL}/${id}`);
    }

    createTransaction(transaction) {
        return axios.post(API_URL, transaction);
    }

    updateTransaction(id, transaction) {
        return axios.put(`${API_URL}/${id}`, transaction);
    }

    deleteTransaction(id) {
        return axios.delete(`${API_URL}/${id}`);
    }
}

export default new TransactionService();
