// 삭제 기능
const deleteButton = document.getElementById('delete-btn');

if (deleteButton) {
    deleteButton.addEventListener('click', event => {
        let id = document.getElementById('article-id').value;
        fetch(`/api/articles/${id}`, {
            method: 'DELETE'
        })
            .then(() => {
                alert('삭제가 완료되었습니다.');
                location.replace('/myblog');
            });
    });
}

// 수정 기능
const modifyButton = document.getElementById('modify-btn');

if (modifyButton) {
    // 클릭 이벤트가 감지되면 수정 API 요청
    modifyButton.addEventListener('click', event => {
        let params = new URLSearchParams(location.search);
        let id = params.get('id');

        fetch(`/api/articles/${id}`, {
            method: 'PUT',
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                title: document.getElementById('title').value,
                content: document.getElementById('content').value
            })
        })
            .then(() => {
                alert('수정이 완료되었습니다.');
                location.replace(`/articles/${id}`);
            });
    });
}

// 등록 기능
const createButton = document.getElementById('create-btn');
if (createButton) {
    createButton.addEventListener("click", (event) => {
        fetch("/api/articles", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                title: document.getElementById("title").value,
                content: document.getElementById("content").value,
                category1: document.getElementById("categorySelect").value,
            }),
        }).then(() => {
            alert("등록 완료되었습니다.");
            location.replace("/myblog");
        }).catch((error) => {
            console.error("등록 중 오류가 발생했습니다.", error);
        });
    });

}



// 댓글 등록 버튼 클릭 이벤트 처리
var submitButton = document.getElementById('submit-button');
submitButton.addEventListener('click', function () {
    addComment();
});

// 댓글 추가 함수
function addComment() {
    var commentInput = document.getElementById('comment-input');
    var commentText = commentInput.value;

    if (commentText.trim() === '') {
        return;
    }

    var authorInput = document.getElementById('author-input');
    var authorName = authorInput.value.trim() || '익명';

    var commentBox = document.getElementById('comment-box');
    var commentId = 'comment-' + (commentBox.childElementCount + 1);

    var newComment = document.createElement('li');
    newComment.setAttribute('id', commentId);
    newComment.setAttribute('class', 'list-group-item d-flex justify-content-between');
    newComment.innerHTML = `
            <div>${commentText}</div>
            <div class="d-flex">
                <div class="font-italic">작성자: ${authorName}</div>
                <button class="badge" onclick="deleteComment('${commentId}')">삭제</button>
            </div>
        `;

    commentBox.appendChild(newComment);

    commentInput.value = '댓글창'; // 댓글 입력창 초기화
    authorInput.value = ''; // 작성자 입력창 초기화
}

// 댓글 삭제 함수
function deleteComment(commentId) {
    var comment = document.getElementById(commentId);
    comment.parentNode.removeChild(comment);
}